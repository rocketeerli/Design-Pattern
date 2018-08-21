package component;

public class File extends FileSystem {
	public File(String fileName) {
		super(fileName);
	}
	//透明模式。
	@Override
	public String toString() {
		String name = "文件夹名：" + this.fileName + "\n";
		for (FileSystem fileSystem : this.fileList) {
			name = name + fileSystem;
		}
		return name;
	}
	
	//安全模式。
//	@Override
//	public String toString() {
//		return "文件名：" + this.fileName + "\n";
//	}
}
