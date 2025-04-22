package interface_example;

public class AinterfaceImpl implements ainterface, MarkerInterface {
	
	@Override
	public void print_interface() {
		System.out.println("AinterfaceImpl_class Override method");
	}
	
	public void only_AinterfaceImpl() {
		System.out.println("only AinterfaceImpl_class method");
	}
}
