package component;

import java.util.ArrayList;
import java.util.List;

//͸��ģʽ�£�û���ļ��С�
public class Folder extends FileSystem {
	private List<FileSystem> fileList = new ArrayList<>();
	public Folder(String fileName) {
		super(fileName);
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
