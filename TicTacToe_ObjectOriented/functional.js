// Initialize game state
function initializeGame() {
    return {
      board: [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ],
      currentPlayer: 'X',
      winner: null
    };
  }
  
  // Check if the game is over
  function isGameOver(game) {
    return game.winner !== null || isGameDraw(game);
  }
  
  // Check if the game is a draw
  function isGameDraw(game) {
    return game.board.every(row => row.every(cell => cell !== ''));
  }
  
  // Check if a player has won
  function isGameWon(game) {
    const board = game.board;
  
    // Check rows, columns, and diagonals
    for (let i = 0; i < 3; i++) {
      if (
        (board[i][0] === board[i][1] && board[i][1] === board[i][2]) ||
        (board[0][i] === board[1][i] && board[1][i] === board[2][i])
      ) {
        return board[i][0];
      }
    }
  
    if (
      (board[0][0] === board[1][1] && board[1][1] === board[2][2]) ||
      (board[0][2] === board[1][1] && board[1][1] === board[2][0])
    ) {
      return board[1][1];
    }
  
    return null;
  }
  
  // Make a move and update game state
  function makeMove(game, row, col) {
    if (!isGameOver(game) && game.board[row][col] === '') {
      const newGame = { ...game };
      newGame.board[row][col] = game.currentPlayer;
      newGame.currentPlayer = game.currentPlayer === 'X' ? 'O' : 'X';
      newGame.winner = isGameWon(newGame);
      return newGame;
    }
    return game;
  }
  
  // Render the game board to the DOM
  function renderGame(game) {
    const boardElement = document.getElementById('board');
  
    // Clear the existing board
    boardElement.innerHTML = '';
  
    // Create and append cells to the board
    for (let row = 0; row < 3; row++) {
      const rowElement = document.createElement('tr');
      for (let col = 0; col < 3; col++) {
        const cellElement = document.createElement('td');
        cellElement.classList.add('cell');
        cellElement.textContent = game.board[row][col];
        cellElement.addEventListener('click', () => handleCellClick(row, col));
        rowElement.appendChild(cellElement);
      }
      boardElement.appendChild(rowElement);
    }
  
    // Update the status message
    const statusElement = document.getElementById('status');
    if (game.winner) {
      statusElement.textContent = `Player ${game.winner} Wins!`;
    } else if (isGameDraw(game)) {
      statusElement.textContent = "It's a Draw!";
    } else {
      statusElement.textContent = `Player ${game.currentPlayer}'s Turn`;
    }
  }
  
  // Handle cell click event
  function handleCellClick(row, col) {
    game = makeMove(game, row, col);
    renderGame(game);
  }
  
  // Initialize the game and render the initial state
  let game = initializeGame();
  renderGame(game);
  