class TicTacToe {
    constructor() {
        this.board = [
            ['', '', ''],
            ['', '', ''],
            ['', '', '']
        ];
        this.currentPlayer = 'X';
        this.status = document.getElementById('status');
        this.cells = document.querySelectorAll('#board .cell');
        this.restartButton = document.getElementById('restart');

        this.cells.forEach(cell => {
            cell.addEventListener('click', () => this.makeMove(cell));
        });

        this.restartButton.addEventListener('click', () => this.restartGame());
    }

    makeMove(cell) {
        const row = cell.parentNode.rowIndex;
        const col = cell.cellIndex;

        if (this.board[row][col] === '' && !this.isGameWon() && !this.isGameDraw()) {
            this.board[row][col] = this.currentPlayer;
            cell.textContent = this.currentPlayer;
            this.togglePlayer();
            this.updateStatus();
        }
    }

    togglePlayer() {
        this.currentPlayer = this.currentPlayer === 'X' ? 'O' : 'X';
    }

    updateStatus() {
        if (this.isGameWon()) {
            this.status.textContent = `Player ${this.currentPlayer} Wins!`;
        } else if (this.isGameDraw()) {
            this.status.textContent = "It's a Draw!";
        } else {
            this.status.textContent = `Player ${this.currentPlayer}'s Turn`;
        }
    }

    isGameWon() {
        // Check rows, columns, and diagonals for a win
        for (let i = 0; i < 3; i++) {
            // Check rows
            if (this.board[i][0] === this.currentPlayer &&
                this.board[i][1] === this.currentPlayer &&
                this.board[i][2] === this.currentPlayer) {
                return true;
            }

            // Check columns
            if (this.board[0][i] === this.currentPlayer &&
                this.board[1][i] === this.currentPlayer &&
                this.board[2][i] === this.currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((this.board[0][0] === this.currentPlayer &&
            this.board[1][1] === this.currentPlayer &&
            this.board[2][2] === this.currentPlayer) ||
            (this.board[0][2] === this.currentPlayer &&
            this.board[1][1] === this.currentPlayer &&
            this.board[2][0] === this.currentPlayer)) {
            return true;
        }

        return false;
    }

    isGameDraw() {
        // Check if all cells are filled (no empty cells left)
        for (let row = 0; row < 3; row++) {
            for (let col = 0; col < 3; col++) {
                if (this.board[row][col] === '') {
                    return false; // There's an empty cell, not a draw yet
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }

    restartGame() {
        // Clear the board and reset game state
        this.board = [
            ['', '', ''],
            ['', '', ''],
            ['', '', '']
        ];
        this.currentPlayer = 'X';

        // Clear the cell contents on the board
        this.cells.forEach(cell => {
            cell.textContent = '';
        });

        // Update the status message to indicate the next player's turn
        this.status.textContent = `Player ${this.currentPlayer}'s Turn`;
    }
}

// Initialize the game
const game = new TicTacToe();
