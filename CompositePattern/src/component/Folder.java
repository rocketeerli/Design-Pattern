package component;

import java.util.ArrayList;
import java.util.List;

//透明模式下，没有文件夹。
public class Folder extends FileSystem {
	private List<FileSystem> fileList = new ArrayList<>();
	public Folder(String fileName) {
		super(fileName);
	}
	//新建文件夹或文件。
	public void add(FileSystem fileSystem) {
		this.fileList.add(fileSystem);
	}
	//删除文件夹或文件。
	public void remove(FileSystem fileSystem) {
		this.fileList.remove(fileSystem);
	}
	//获得下面的所有文件、文件夹信息。
	public List<FileSystem> getChildren() {
		return this.fileList;
	}
	@Override
	public String toString() {
		String name = "文件夹名：" + this.fileName + "\n";
		for (FileSystem fileSystem : fileList) {
			name = name + fileSystem;
		}
		return name;
	}
}
