> 참조 포스팅

[자바 [JAVA] - Stack Interface (스택 인터페이스)](https://st-lab.tistory.com/173)

[자바 [JAVA] - Stack (스택) 구현하기](https://st-lab.tistory.com/174)

# 🌟 Stack 인터페이스 작성
## 1. Stack 인터페이스
Stack 자료구조는 처음 들어온 데이터가 마지막에 나가는 후입선출 구조를 가진다.

애플리케이션 개발 중 java.lang.StackOverflowError 가 종종 발생하는데 이는 보통 재귀가 깊어지면서 발생하게 된다. stack 메모리에 메서드가 재귀적으로 호출되어 값들이 쌓이게 되면서 용량보다 많은 데이터를 담은 경우 오류가 발생한다.

## 2. Stack 인터페이스에 선언된 대표 메서드
| 메소드              | 리턴타입    | 설명                                                                  |
|------------------|---------|---------------------------------------------------------------------|
| push(E item)     | E       | 스택의 맨 위에 요소를 추가                                                     |
| pop()            | E       | 스택의 맨위의 요소를 제거한 뒤 반환                                                |
| peek()           | E       | 스택의 맨위의 요소를 제거하지 않고 반환                                              |
| search(Object o) | int     | 스택의 상단부터 탐색하여 지정된 객체가 있는 요소의 위치를 반환<br/>없는 경우 -1을 반환한다              |
| size()           | int     | 현재 스택에 있는 요소의 개수를 반환                                                |
| clear()          | void    | 모든 요소들을 제거                                                          |
| empty()          | int     | 현재 스택에 요소가 존재하지 않을 경우 true,<br/>그 외의 경우는 false를 반환                  |

여기서 중요한 내용은 search() 메소드는 스택 내부 배열의 인덱스 값이 아닌 스택의 상단으로부터 몇 번째에 위치하는지를 반환한다는 점이다.

## 3. Stack 인터페이스 코드
```
package test;
/**
 * 
 * 자바 stack Interface입니다. <br>
 * StackInterface는 Stack에 의해 구현됩니다.
 * 
 * @author st_lab
 * @param <E> the type of elements in this Stack
 *
 * @version 1.0
 * 
 */
 
 
public interface StackInterface<E> {
	
	/**
	 * 스택의 맨 위에 요소를 추가합니다. 
	 * 
	 * @param item 스택에 추가할 요소 
	 * @return 스택에 추가된 요소 
	 */
	E push(E item);
	
	/**
	 * 스택의 맨 위에 있는 요소를 제거하고 제거 된 요소를 반환합니다.
	 * 
	 * @return 제거 된 요소 
	 */
	E pop();
	
	/**
	 * 스택의 맨 위에 있는 요소를 제거하지 않고 반환합니다.
	 * 
	 * @return 스택의 맨 위에 있는 요소 
	 */
	E peek();
	
	/**
	 * 스택의 상반 부터 특정 요소가 몇 번째 위치에 있는지를 반환합니다.
	 * 중복되는 원소가 있을경우 가장 위에 있는 요소의 위치가 반환됩니다.
	 *
	 * @param value 스택에서 위치를 찾을 요소
	 * @return 스택의 상단부터 처음으로 요소와 일치하는 위치를 반환.
	 *         만약 일치하는 요소가 없을 경우 -1 을 반환 
	 */
	/* 
	 *         ________
	 *         | a    |
	 * idx 3   |______|   search("w")
	 *         | e    |   --> 상단(idx 3)으로 부터 3번 째에 위치 
	 * idx 2   |______|       == return 되는 값 : 3
	 *         | w    |
	 * idx 1   |______| 
	 *         | k    |
	 * idx 0   |______|
	 * 
	 */ 
	int search(Object value);
	
	/**
	 * 스택의 요소 개수를 반환합니다.
	 * 
	 * @return 스택에 있는 요소 개수를 반환 
	 */
	int size();
	
	/**
	 * 스택에 있는 모든 요소를 삭제합니다.
	 */
	void clear();
	
	/**
	 * 스택에 요소가 비어있는지를 반환합니다.
	 * 
	 * @return 스택에 요소가 없을 경우 {@code true}, 그 외의 경우 {@code false}를 반환
	 */
	boolean empty();
}
```

# 🌟 Stack 구현하기
![그림1](https://raw.githubusercontent.com/hyensukim/Algorithme-Theory/main/images/%EC%8A%A4%ED%83%9D.png)

스택은 위 구조로 되어 있다.

`Bottom` : 가장 밑에 있는 데이터 또는 그 데이터의 인덱스.
`Top` : 가장 위에 있는 데이터 또는 그 데이터의 인덱스.
`Capacity` : 데이터를 담기 위한 용량.
`size` : 데이터의 실제 갯수.

스택을 구현하기 전에 중요한 사항이 있다.

모든 자료구조는 `동적 할당` 을 전제로 한다. 즉, 데이터를 담을 수 있는 용량이 동적으로 변한다는 것을 의미한다.

데이터 갯수를 알 수 없는데 배열을 쓰고 싶을 때 일반적으로 컬렉션을 사용한다. 왜냐하면, 사이즈를 정하지 않고도 동적으로 활용이 가능하기 때문이다.

## 목차
- 클래스 및 생성자
- resize 메소드 구현
- push 메소드 구현
- pop 메소드 구현
- peek 메소드 구현
- search, size, clear, empty 메소드 구현

### 클래스 및 생성자 구성
Stack 인터페이스인 StackInterface를 implements 해준다.
```
[Stack.java]
package test;

import test.StackInterface;
 
public class Stack<E> implements StackInterface<E> {
 
	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 
	private static final Object[] EMPTY_ARRAY = {};	// 빈 배열 
	
	private Object[] array;	// 요소를 담을 배열  
	private int size;	// 요소 개수 
	
	
	// 생성자1 (초기 공간 할당 X) 
	public Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	// 생성자2 (초기 공간 할당 O) 
	public Stack(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
}
```

`DEFAULT_CAPACITY` : 배열이 생성 될 때의 최초 할당 크기(용량)이자 최소 할당 용량 변수로 기본값은 10
`EMPTY_ARRAY` : 아무 것도 없는 빈 배열(용량이 0)
`array` : 요소들을 담을 배열
`size` : 베열에 담긴 요소(원소)의 개수 변수

### 동적할당을 위한 resize 메소드 구현
처음 우리는 들어오는 데이터에 갯수에 따라 최적화된 용량이 필요하다. 만약 데이터는 적은데 용량이 크면 메모리가 낭비되고, 반대로 용량은 적은데 데이터가 많으면 넘치는 데이터들은 보관이 불가하다. 

그렇기 때문에 size가 용량에 얼마만큼 차있는지를 확인하고, 적절한 크기에 맞게 배열의 용량을 변경해야 한다. 

```
private void resize() {
		
	// 빈 배열일 경우 (capacity is 0)
	if(Arrays.equals(array, EMPTY_ARRAY)) {
		array = new Object[DEFAULT_CAPACITY];
		return;
	}
		
	int arrayCapacity = array.length;	// 현재 용적 크기 
		
	// 용적이 가득 찰 경우
	if(size == arrayCapacity) {
		int newSize = arrayCapacity * 2;
		
		// 배열 복사
		array = Arrays.copyOf(array, newSize);
		return;
	}
		
	// 용적의 절반 미만으로 요소가 차지하고 있을 경우
	if(size < (arrayCapacity / 2)) {
			
		int newCapacity = (arrayCapacity / 2);
			
		// 배열 복사
		array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
		return;
	}
}
```

### push(E item) 메소드 구현
Stack의 push는 항상 최상단(맨 위)에 데이터를 추가해야하므로 한 종류밖에 없다. 리스트로 치면 add(E value)와 같은 역할이다.

가장 마지막 부분(최상단)에 추가 - push(E item)

```
@Override
public E push(E item) {
		
	// 용적이 꽉 차있다면 용적을 재할당 해준다. 
	if (size == array.length) {
		resize();
	}
	array[size] = item;	// 마지막 위치에 요소 추가 
	size++;	// 사이즈 1 증가 
		
	return item;
}
```

### pop() 메소드 구현

```
@Override
public E pop() {
		
	// 만약 삭제할 요소가 없다면 Stack이 비어있다는 의미이므로 예외 발생시키기
	if(size == 0) {
		throw new EmptyStackException();
	}
		
	@SuppressWarnings("unchecked")
	E obj = (E) array[size - 1];	// 삭제될 요소를 반환하기 위한 임시 변수 
		
	array[size - 1] = null;	// 요소 삭제 
		
	size--;	// 사이즈 1 감소 
	resize();	// 용적 재할당 
		
	return obj;
}
```
여기서 @SuppressWarnings("unchecked") 에 대해 잠깐 언급하고 가겠다.

@SuppressWarnings("unchecked")을 붙이지 않으면 type safe(타입 안정성)에 대해 경고를 보낸다. 반환되는 것을 보면 E 타입으로 캐스팅을 하고 있고 그 대상이 되는 것은 Object[] 배열의 Object 데이터다. 즉, Object -> E 타입으로 변환을 하는 것인데 이 과정에서 변환할 수 없는 타입일 가능성이 있다는 경고로 메소드 옆에 경고표시가 뜨는데, 우리가 push하여 받아들이는 데이터 타입은 유일하게 E 타입만 존재한다. 

그렇기 때문에 형 안정성이 보장된다. 한마디로 ClassCastException이 뜨지 않으니 이 경고들을 무시하겠다는 것이 @SuppressWarnings("unchecked") 이다. 물론 절대 남발하면 안되고, **형 변환시 예외 가능성이 없을 확실한 경우에 최소한의 범위에서 써주는 것이 좋다. 그렇지 않으면 중요한 경고 메세지를 놓칠 수도 있기 때문이다.**

### peek() 메소드 구현

```
@SuppressWarnings("unchecked")
@Override
public E peek() {
	// 만약 삭제할 요소가 없다면 Stack이 비어있다는 의미이므로 예외 발생시키기
	if(size == 0) {
		throw new EmptyStackException();
	}
		
	return (E) array[size - 1];
}
```

### search, size, empty, clear 메소드 구현

1. search(Object o) 메소드

```
@Override
public int search(Object value) {
	// value가 null일 때는 eqauls(null)이되어 null pointer exception이 발생할 수 있으니,
	// == 로 null값을 비교해준다.
	if(value == null) {
		for(int idx = size - 1; idx >= 0; idx--) {
			if(array[idx] == null) {
				return size - idx;
			}
		}
	} else {
		for(int idx = size - 1; idx >= 0; idx--) {
	
			// 같은 객체를 찾았을 경우 size - idx 값을 반환 
			if(array[idx].equals(value)) {
				return size - idx;
			}
		}
	}
	return -1;
}
```

2. size() 메소드

```
@Override
public int size() {
	return size;
}
```

3. clear() 메소드
clear()는 모든 요소들을 비워버리는 작업이다. size 또한 0으로 초기화해주고, 배열의 용량 또한 현재 용량의 절반으로 줄일 수 있도록 해준다.

용량을 초기 값으로 초기화 해주지 않는 이유는 현재 배열의 용량은 결국 데이터를 해당 용량에 만족하는 조건만큼 썼다는 의미이므로, 다음 에 사용 시에도 그 정도의 용량을 쓸 것으로 예상되기 때문이다.

```
@Override
public void clear() {
		
	// 저장되어있던 모든 요소를 null 처리 해준다.
	for(int i = 0; i < size; i++) {
		array[i] = null;
	}
	size = 0;
	resize();
}
```

모든 배열을 명시적으로 null로 처리해주는 것이 좋다

4. empty() 메서드

```
@Override
public boolean empty() {
	return size == 0;
}
```