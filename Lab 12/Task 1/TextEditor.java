public class TextEditor{
    private StringBuilder text = new StringBuilder();
    private String clipboard = "";
    private String lastState = "";

    public void write(String str) {
        saveState();
        text.append(str);
    }

    public void cut(int start, int end) {
        saveState();
        clipboard = text.substring(start, end);
        text.delete(start, end);
    }

    public void copy(int start, int end) {
        clipboard = text.substring(start, end);
    }

    public void paste(int position) {
        saveState();
        text.insert(position, clipboard);
    }

    private void saveState() {
        lastState = text.toString();
    }

    public void undo() {
        text = new StringBuilder(lastState);
    }

    public String getText() {
        return text.toString();
    }

    public String getClipboard() {
        return clipboard;
    }
}
