public class PasteCommand implements Command {
    private TextEditor editor;
    private int position;

    public PasteCommand(TextEditor editor, int position) {
        this.editor = editor;
        this.position = position;
    }

    public void execute() {
        editor.paste(position);
    }

    public void undo() {
        editor.undo();
    }
}
