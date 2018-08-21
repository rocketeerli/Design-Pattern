package component;

import java.util.ArrayList;
import java.util.List;

public abstract class FileSystem {
	protected List<FileSystem> fileList = new ArrayList<>();
	protected String fileName = "";
	public FileSystem(String fileName) {
		this.fileName = fileName;
	}
	//�½��ļ��л��ļ���
	public void add(FileSystem fileSystem) {
		this.fileList.add(fileSystem);
	}
	//ɾ���ļ��л��ļ���
	public void remove(FileSystem fileSystem) {
		this.fileList.remove(fileSystem);
	}
	//�������������ļ����ļ�����Ϣ��
	public List<FileSystem> getChildren() {
		return this.fileList;
	}
	@Override
	public String toString() {
		String name = "�ļ�������" + this.fileName + "\n";
		for (FileSystem fileSystem : fileList) {
			name = name + fileSystem;
		}
		return name;
	}
}

//��ȫģʽ��
//public abstract class FileSystem {
//	protected String fileName = "";
//	public FileSystem(String fileName) {
//		this.fileName = fileName;
//	}
//}
