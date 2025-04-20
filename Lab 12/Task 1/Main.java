public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.write("Rabya Khan");
        System.out.println("Initial text: " + editor.getText());
        System.out.println("\n");

        Command cut = new CutCommand(editor, 6, 10);
        Button cutButton = new Button(cut);
        cutButton.click();
        System.out.println("After cut: " + editor.getText());
        System.out.println("\n");

        cutButton.undoClick();
        System.out.println("After undo cut: " + editor.getText());
        System.out.println("\n");

        Command copy = new CopyCommand(editor, 0, 5);
        Button copyButton = new Button(copy);
        copyButton.click();
        System.out.println("Clipboard after copy: " + editor.getClipboard());
        System.out.println("\n");

        Command paste = new PasteCommand(editor, 10);
        Button pasteButton = new Button(paste);
        pasteButton.click();
        System.out.println("After paste: " + editor.getText());
        System.out.println("\n");

        pasteButton.undoClick();
        System.out.println("After undo paste: " + editor.getText());
    }
}
