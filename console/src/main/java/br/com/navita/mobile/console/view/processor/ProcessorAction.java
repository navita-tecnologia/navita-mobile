package br.com.navita.mobile.console.view.processor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONSerializer;

import org.apache.struts2.interceptor.ParameterAware;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.InvalidDeviceDataException;
import br.com.navita.mobile.console.exception.InvalidLicenseKeyException;
import br.com.navita.mobile.console.operator.ConnectorOperator;
import br.com.navita.mobile.console.operator.Operator;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.view.RawActionSupport;
import br.com.navita.mobile.console.view.rawdata.ProcessorRaw;
import br.com.navita.mobile.domain.MobileBean;

public class ProcessorAction extends RawActionSupport implements ParameterAware, ProcessorRaw{
	
	private String retType;
	private String connectorTag;
	private String operationTag;
	private String raw;
	private String pin;
	private String email;
	private String carrier;
	private String device;
	private String brand;
	
	
	private InputStream inStream;	
	private Map<?,?> params;
	
	
	private BaseConnectorService<Connector> baseConnectorService;
	private BaseOperationService<Operation> baseOperationService;
	
	private ConnectorOperator connectorOperator;
	private Operator operator;
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public void setConnectorOperator(ConnectorOperator connectorOperator) {
		this.connectorOperator = connectorOperator;
	}
	
	
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
	
	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
	}
	
	@Override
	public String getPin() {		
		return pin;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Override
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Map<?, ?> getParams() {
		return params;
	}

	public void setParams(Map<?, ?> params) {
		this.params = params;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String getConnectorTag() {		
		return connectorTag;
	}
	
	public void setConnectorTag(String connectorTag) {
		this.connectorTag = connectorTag;
	}
	
	@Override
	public String getOperationTag() {		
		return operationTag;
	}
	
	public void setOperationTag(String operationTag) {
		this.operationTag = operationTag;
	}
	
	@Override
	public String getRaw() {		
		return raw;
	}
	
	public void setRaw(String raw) {
		this.raw = raw;
	}	
	
	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setParameters(Map params) {
		this.params = params;

	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() {		
		try {
			MobileBean obj = new MobileBean();
			
			prepareAndCheckParameters();
			Connector connector = baseConnectorService.findByTag(connectorTag);
			boolean isExternalOperation = connector.getOperationType() == null;
			boolean isConnectorLicenseInUse = isUsingConnectorLicense(connector);
			
			if(! isExternalOperation){
				Operation operation = null;
				operation = baseOperationService.findByTagAndConnectorId(connector.getId(),operationTag);
				if(!isConnectorLicenseInUse){
					checkOperationLicense(operation);
				}
				obj = operator.doOperation(operation, (Map<String, Object>) params);
				
			}else{
				obj = connectorOperator.doConnectorOperation(connector, (Map<String, Object>) params);
			}
					
			registerLicense(); 	//license use
			registerAction(); 	//statistics
			
			serializeBean(obj);	
			
		} catch (Throwable t) {
			serializeBean(failBean(t));			
			
		}
		
		return retType;
	}

	
	private void serializeBean(MobileBean bean) {
		byte[] buff = null;
		buff = JSONSerializer.toJSON(bean).toString().getBytes();		
		setInStream(new ByteArrayInputStream(buff));		
	}

	private void checkOperationLicense(Operation operation)  throws InvalidLicenseKeyException{
		
		
	}

	private void registerAction() {
		
		
	}

	private void registerLicense() {
		
		
	}

	private MobileBean failBean(Throwable t) {
		MobileBean bean = new MobileBean();
		String message = t.getMessage();
		if(message == null|| message.isEmpty()){
			message = t.getClass().getName();
		}
		bean.setMessage(message);
		bean.setResultCode(1);
		return bean;
	}

	private boolean isUsingConnectorLicense(Connector connector)  throws InvalidLicenseKeyException{
		
		return true;
		
	}

	
	private void prepareAndCheckParameters() throws InvalidDeviceDataException {
		
		
	}
	
	
}
