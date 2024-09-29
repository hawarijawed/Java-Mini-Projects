package template_design_pattern;

public class csvFileProcessing extends FileHandling{
		private String[][]file_contents;
		
		@Override
		public void readFile(String path) {
			System.out.println("Reading the CSV file...");
			file_contents = new String[][] { 
	            { "Name", "Age", "Country" }, 
	            { "Alice", "30", "USA" }, 
	            { "Bob", "25", "UK" }
	        };
		}
		
		@Override
		public void processData() {
			System.out.println("Analysing the CSV file contents...");
			for(String[] row: file_contents) {
				System.out.println(String.join(", " , row));
			}
			//Next logic operations need to be performed on the file goes from here onwards
		}
}
