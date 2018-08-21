package client;

import component.File;
import component.FileSystem;
import component.Folder;

public class Client {

	public static void main(String[] args) {
		File root = new File("我的电脑");
		File branch = new File("我的图片");
		File leaf = new File("图片.jpg");
		root.add(branch);
		branch.add(leaf);
		display(root);
	}
	public static void display(FileSystem root) {
		for (FileSystem fileSystem : root.getChildren()) {
			System.out.println(fileSystem);
		}
	}
	
	//安全模式。
//	public static void main(String[] args) {
//		Folder root = new Folder("我的电脑");
//		Folder branch = new Folder("我的图片");
//		File leaf = new File("图片.jpg");
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
