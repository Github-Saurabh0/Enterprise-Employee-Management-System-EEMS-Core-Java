@Override
public boolean save(Employee e) {
    try (FileWriter fw = new FileWriter(filePath, true);
         BufferedWriter bw = new BufferedWriter(fw)) {

        bw.write(e.toString());
        bw.newLine();
        return true;

    } catch (IOException ex) {
        System.err.println("ERROR: Could not save employee → " + ex.getMessage());
        return false;
    }
}
