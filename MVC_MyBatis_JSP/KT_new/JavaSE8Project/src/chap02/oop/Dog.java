package chap02.oop;
public class Dog {
	
	// ���Ը� ��Ÿ���� ����(�Ӽ�)
  private int weight;
  
  // �⺻������
  public Dog() {
     weight = 42;
  }
  
  // weight ������ ��ȯ�ϴ� Getter method.
  public int getWeight() {
    return weight;
  }
  
  // weight �������� �����ϴ� Setter method.
  public void setWeight(int newWeight) {
    weight = newWeight;
  }
}
