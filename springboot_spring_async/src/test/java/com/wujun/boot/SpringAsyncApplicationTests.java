package com.wujun.boot;

import com.wujun.boot.service.impl.AsyncServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAsyncApplicationTests {
	@Autowired
	private AsyncServiceImpl asyncService;

	@Test
	public void contextLoads() {
	}



	@Test
	public void AsyncTest(){
		System.out.println("start");
		asyncService.asyncMethodWithVoidReturnType();
		System.out.println("end");
	}

	@Test
	public void testAsyncAnnotationForMethodWithReturnType() throws ExecutionException, InterruptedException {
		System.out.println("调用异步方法start. "+Thread.currentThread().getName());
		Future<String> future = asyncService.asyncMethodWithReturnType();
		while(true){
			if (future.isDone()){
				System.out.println("result from asynchronous process - "+future.get());
				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}

	@Test
	public void testAsyncMethodWithConfiguredExecutor(){
		System.out.println("start");
		asyncService.asyncMethodWithConfiguredExecutor();
		System.out.println("end");
	}

}
