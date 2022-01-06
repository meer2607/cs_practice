//An implementation of dynamic arrays using static arrays
//21-12-21

public class DynamicArray{
  public static void main(String[] args) {
    DynamicArray array = new DynamicArray(5);
    System.out.println(array);

    array.append(5);
    array.append(23);
    System.out.println(array);

    array.replace(1, 6);
    System.out.println(array);

    array.addAt(0, 52);
    System.out.println(array);

    array.remove(0);
    System.out.println(array);
  }

  private int[] dynamicArray;
  private int capacity, size;

  //Capacity 2:
  public DynamicArray(){
    this.dynamicArray = new int[2];
    this.capacity = 2;
    this.size = 0;
  }

  //Specific initial capacity:
  public DynamicArray(int capacity){
    this.dynamicArray = new int[capacity];
    this.capacity = capacity;
    this.size = 0;
  }

  public void append(int value){
    adjustCapacity();

    dynamicArray[size] = value;
    size++;
  }

  public void addAt(int index, int value){
    adjustCapacity();

    if(index<0 || index>size){
      throw new ArrayIndexOutOfBoundsException();
    }

    for(int i=size; i>index; i--)
      dynamicArray[i] = dynamicArray[i-1];

    dynamicArray[index] = value;
    size++;
  }

  public int remove(int index){
    if(index<0 || index>=size || size==0){
      throw new ArrayIndexOutOfBoundsException();
    }

    int value = dynamicArray[index];
    for(int i=index; i<size-1; i++)
      dynamicArray[i] = dynamicArray[i+1];

    size--;
    adjustCapacity();

    return value;
  }

  public int replace(int index, int value){
    if(index<0 || index>=size){
      throw new ArrayIndexOutOfBoundsException();
    }

    int oldValue = dynamicArray[index];
    dynamicArray[index] = value;

    return oldValue;
  }

  public int get(int index) throws ArrayIndexOutOfBoundsException{
    if(index<0 || index>=size){
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.dynamicArray[index];
  }

  public int size(){
    return this.size;
  }

  private int adjustCapacity(){
    if(size>=capacity)
      capacity*=2;
    else if(size<=capacity/4)
      capacity/=2;

    int[] tempArray = new int[capacity];
    for(int i=0; i<size; i++)
      tempArray[i] = dynamicArray[i];
    dynamicArray = tempArray;

    return capacity;
  }

  public String toString(){
    String stringRepresentation = "[";
    for(int i=0; i<size; i++)
      stringRepresentation += dynamicArray[i] + ", ";

    if(!"[".equals(stringRepresentation))
      stringRepresentation = stringRepresentation.substring(0,
                               stringRepresentation.length()-2);

    return stringRepresentation+"]";
  }
}
