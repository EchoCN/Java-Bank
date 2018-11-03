package Echo.bank;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {
	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;
	
	public void setType(CustomerType type) {
		this.type = type;
	}


	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}


	public void start(){
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			public void run() {
				while(true) {
					
					
					switch(type) {
					case COMMON:
						commonService();
						break;
					case EXPRESS:
						
						break;
					case VIP:
						break;
					}
				}
			}
		});
	}

			private void commonService() {
				String windowName = "第"+windowId+"号"+type+"窗口";
				System.out.println("正在获取任务");
				Integer number = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
				if(number != null) {
					long beginTime = System.currentTimeMillis();
					int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					long serveTime = new Random().nextInt(maxRand) + 1 + Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(serveTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时"+costTime/1000+"秒");
				}else {
					System.out.println(windowName + "没有取到服务,先休息一下");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			private void expressService() {
				String windowName = "第"+windowId+"号"+type+"窗口";
				System.out.println("正在获取任务");
				Integer number = NumberMachine.getInstance().getExpressManager().fetchServiceNumber();
				if(number != null) {
					long beginTime = System.currentTimeMillis();
					//int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					//long serveTime = new Random().nextInt(maxRand) + 1 + Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(Constants.MIN_SERVICE_TIME);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时"+costTime/1000+"秒");
				}else {
					System.out.println(windowName + "没有取到服务,先休息");
					commonService();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			private void vipService() {
				String windowName = "第"+windowId+"号"+type+"窗口";
				System.out.println("正在获取任务");
				Integer number = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
				if(number != null) {
					long beginTime = System.currentTimeMillis();
					int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					long serveTime = new Random().nextInt(maxRand) + 1 + Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(serveTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时"+costTime/1000+"秒");
				}else {
					System.out.println(windowName + "没有取到服务");
					commonService();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
}
