package turing;

public class Tape {
    private Cell currentCell; // current cell pointer

    public Tape() { // Creating constructor
        Cell newCell = new Cell();
        newCell.content = ' ';
        newCell.next = null;
        newCell.prev = null;
        currentCell = newCell;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public char getContent() { // Getting method
        return currentCell.content;
    }

    public void setContent(char ch) { // Setting method
        currentCell.content = ch;
    }

    public void moveRight() { // Moving Right method
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = null;
            newCell.prev = currentCell;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    public void moveLeft() { // Moving left method
        if (currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = null;
            newCell.next = currentCell;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;
    }

    public String getTapeContents() { // Getting tape contents method
        Cell pointer = currentCell;
        while (pointer.prev != null) {
            pointer = pointer.prev;
        }
        String strContent = "";

        while (pointer != null) {
            strContent += pointer.content;
            pointer = pointer.next;
        }
        strContent = strContent.trim();
        return strContent;
    }
}