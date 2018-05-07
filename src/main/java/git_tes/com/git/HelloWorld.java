package git_tes.com.git;


public class HelloWorld {

	
	public static void main(String[] args) {
		String[] sMethod ={"name"};
			Student s = (Student) getBean("git_tes.com.git.Student",sMethod);
			System.out.println("谁出ddddddd："+s.getName());
		String[] fcMethod ={"no"};
			FirstClass fc = (FirstClass) getBean("git_tes.com.git.FirstClass",fcMethod);
			System.out.println("谁出："+fc.getNo());
	}

	public void testMethod(){
		System.out.println("222测试方法的作用！");
		System.out.println("测试方法的作用！dddddddddd");
	}

	
	public static Object getBean(String packageName, String...methodName){
		try {
			Class commonClass = Class.forName(packageName);
			Object object = commonClass.newInstance();
			for(int i=0; i<methodName.length; i++){
				Class<?> methodType = commonClass.getMethod("get"+upperCase(methodName[i])).getReturnType();
				System.out.println("====:"+methodType.getName()+" "+methodType.getSimpleName());
				commonClass.getMethod("set"+upperCase(methodName[i]), methodType).invoke(object, "李超");
			}
			return object;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String upperCase(String str) {  
		   return str.substring(0, 1).toUpperCase() + str.substring(1);  

}
}
