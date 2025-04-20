public class CutCommand implements Command {
    private TextEditor editor;
    private int start, end;

    public CutCommand(TextEditor editor, int start, int end) {
        this.editor = editor;
        this.start = start;
        this.end = end;
    }

    public void execute() {
        editor.cut(start, end);
    }

    public void undo() {
        editor.undo();
    }
}

