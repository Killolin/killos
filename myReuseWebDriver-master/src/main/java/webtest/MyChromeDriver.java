package webtest;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.remote.CapabilityType.PROXY;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.Response;

public class MyChromeDriver extends ChromeDriver {
	
//	mystartClient(localserver);
//	mystartSession(sessionID);
	// ��������capabilities
		private Capabilities myCapabilities;
	 
		public MyChromeDriver(String sessionID,String localserver) {
			mystartClient(localserver);
			mystartSession(sessionID);
		}
		//��дstartSession���������Է�ֹ���ø���startSession���������´򿪶�������
		@Override
		protected void startSession(Capabilities desiredCapabilities) {
			// Do Nothing
		}
		//��д��startClient���������ڴ���localserver����������ĵ�ַ�������sessionID���ҳ����õ������
		protected void mystartClient(String localserver) {
			HttpCommandExecutor delegate = null;
	 
			try {
				URL driverserver = new URL(localserver);
				delegate = new myHttpCommandExecutor(driverserver);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			setCommandExecutor(delegate);
			System.out.println("Connect to the existing browser");
		}
		//��д��startSession���������ڴ���sessionID�����localserver���ҳ����õ������
		protected void mystartSession(String sessionID) {
	 
			if (!sessionID.isEmpty()) {
				super.setSessionId(sessionID);
			}
			Command command = new Command(super.getSessionId(), DriverCommand.STATUS);
			Response response;
			try {
				response = ((myHttpCommandExecutor)getCommandExecutor()).execute(command);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Can't use this Session");
				return;
			}
			//��ӡϵͳ��Ϣ
			System.out.println("response.getValue()" + response.getValue());
			if (response.getValue() instanceof Exception)
			{
				((Exception)response.getValue()).printStackTrace();
			}
			
			//Ϊ����ִ��Script
			this.myCapabilities = dropCapabilities(new ChromeOptions()) ;
	 
		}
		
		private static Capabilities dropCapabilities(Capabilities capabilities) 
		{
			if (capabilities == null) {
				return new ImmutableCapabilities();
			}
	 
			MutableCapabilities caps = new MutableCapabilities(capabilities);
	 
			// Ensure that the proxy is in a state fit to be sent to the extension
			Proxy proxy = Proxy.extractFrom(capabilities);
			if (proxy != null) {
				caps.setCapability(PROXY, proxy);
			}
	 
			return caps;
	}
	 
		@Override
		public void quit() {
			try {
				execute(DriverCommand.QUIT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
		public Capabilities getCapabilities() {
			return myCapabilities;
		}
	 

}