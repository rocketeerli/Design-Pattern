package component;

public class File extends FileSystem {
	public File(String fileName) {
		super(fileName);
	}
	//͸��ģʽ��
	@Override
	public String toString() {
		String name = "�ļ�������" + this.fileName + "\n";
		for (FileSystem fileSystem : this.fileList) {
			name = name + fileSystem;
		}
		return name;
	}
	
	//��ȫģʽ��
//	@Override
//	public String toString() {
//		return "�ļ�����" + this.fileName + "\n";
//	}
}
