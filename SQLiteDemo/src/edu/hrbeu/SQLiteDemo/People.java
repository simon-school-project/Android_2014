package edu.hrbeu.SQLiteDemo;

public class People {
	public int ID = -1;
	public String Name;
	public int Age;
	public float Height;
	
	@Override
	public String toString(){
		String result = "";
		result += "ID��" + this.ID + "��";
		result += "������" + this.Name + "��";
		result += "���䣺" + this.Age + "�� ";
		result += "��ߣ�" + this.Height + "��";
		return result;
	}
}
