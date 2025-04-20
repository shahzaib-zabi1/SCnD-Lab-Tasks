public class CopyCommand implements Command {
    private TextEditor editor;
    private int start, end;

    public CopyCommand(TextEditor editor, int start, int end) {
        this.editor = editor;
        this.start = start;
        this.end = end;
    }

    public void execute() {
        editor.copy(start, end);
    }

    public void undo() {
    }
}

