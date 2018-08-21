package client;

import component.File;
import component.FileSystem;
import component.Folder;

public class Client {

	public static void main(String[] args) {
		File root = new File("�ҵĵ���");
		File branch = new File("�ҵ�ͼƬ");
		File leaf = new File("ͼƬ.jpg");
		root.add(branch);
		branch.add(leaf);
		display(root);
	}
	public static void display(FileSystem root) {
		for (FileSystem fileSystem : root.getChildren()) {
			System.out.println(fileSystem);
		}
	}
	
	//��ȫģʽ��
//	public static void main(String[] args) {
//		Folder root = new Folder("�ҵĵ���");
//		Folder branch = new Folder("�ҵ�ͼƬ");
//		File leaf = new File("ͼƬ.jpg");
//		root.add(branch);
//		branch.add(leaf);
//		display(root);
//	}
//	public static void display(Folder root) {
//		for (FileSystem fileSystem : root.getChildren()) {
//			System.out.println(fileSystem);
//		}
//	}
}
