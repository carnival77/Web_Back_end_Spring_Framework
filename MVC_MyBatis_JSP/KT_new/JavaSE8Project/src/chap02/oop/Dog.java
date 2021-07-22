package chap02.oop;
public class Dog {
	
	// 무게를 나타내는 변수(속성)
  private int weight;
  
  // 기본생성자
  public Dog() {
     weight = 42;
  }
  
  // weight 변수를 반환하는 Getter method.
  public int getWeight() {
    return weight;
  }
  
  // weight 변수값을 변경하는 Setter method.
  public void setWeight(int newWeight) {
    weight = newWeight;
  }
}
