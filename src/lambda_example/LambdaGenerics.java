package lambda_example;

// 람다식에 제네릭 적용
@FunctionalInterface
public interface LambdaGenerics<T> {
	
	public T calc(T a, T b);
}
