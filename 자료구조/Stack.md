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
| add(E e)         | boolean | 요소를 꼬리에 추가한다. 만약 큐가 모두 찼을 경우<br/>IllegalStateException 예외 발생        |
| offer(E e)       | boolean | 요소를 꼬리에 추가한다. 만약 큐가 모두 찼을 경우에도<br/>IllegalStateException 예외 발생하지 않음 |
| peek()           | E       | 헤드를 삭제하지 않고 검색하여 요소를 반환                                             |
| poll()           | E       | 헤드를 검색 및 삭제하면서 요소를 반환                                               |
| addLast(E e)     | void    | 요소를 꼬리에 추가한다. 만약 큐가 모두 찼을 경우<br/>IllegalStateException 예외 발생        |
| addFirst(E e)    | void    | 요소를 헤드에 추가한다. 만약 큐가 모두 찼을 경우<br/>IllegalStateException 예외 발생        |
| offerLast(E e)   | boolean | 요소를 꼬리에 추가                                                          |
| offerFirst(E e)  | boolean | 요소를 헤드에 추가                                                          |
| peekFirst()      | E       | 헤드에 있는 요소를 삭제하지 않고 반환                                               |
| peekLast()       | E       | 꼬리에 있는 요소를 삭제하지 않고 반환                                               |
| pollFirst()      | E       | 헤드를 검색 및 삭제하면서 요소를 반환                                               |
| pollLast()       | E       | 꼬리를 검색 및 삭제하면서 요소를 반환                                               |
| size()           | int     | 요소의 개수를 반환                                                          |
|                  |         |                                                                     |
| 메소드              | 리턴타입    | 설명                                                                  |
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
