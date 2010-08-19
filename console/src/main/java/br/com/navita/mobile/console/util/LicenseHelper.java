package br.com.navita.mobile.console.util;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.exception.InvalidDeviceDataException;
import br.com.navita.mobile.console.exception.InvalidLicenseKeyException;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;
import br.com.navita.mobile.console.view.rawdata.ProcessorRaw;

public  class LicenseHelper {

	private static final Logger LOG = Logger.getLogger(LicenseHelper.class.getName());
	private static String PRIVATE_KEY = "RrSe916DqrdQANfFKaQkgQ==";

	private LicenseService licenseService;
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	public void checkOperationLicense(Operation operation)  throws InvalidLicenseKeyException{
		LicenseBundle bundle = operation.getLicenseBundle();
		if(bundle == null){
			throw new InvalidLicenseKeyException("Neither Connector or Operation license bundle found");
		}
		String licenseKey = operation.getLicenseKey();
		String tag = operation.getTag();
		checkLicense(licenseKey,tag,"operation");

	}

	public boolean isUsingConnectorLicense(Connector connector)  throws InvalidLicenseKeyException{
		LicenseBundle bundle = connector.getLicenseBundle();
		if(bundle == null){
			return false;
		}
		String licenseKey = connector.getLicenseKey();
		String tag = connector.getTag();
		checkLicense(licenseKey,tag,"connector");

		return true;

	}

	public void checkLicense(String licenseKey, String tag, String type) throws InvalidLicenseKeyException {

		String plain = null;
		try {
			plain = Decryptor.decrypt(licenseKey, PRIVATE_KEY);			
		} catch (DecryptorException e) {
			throw new InvalidLicenseKeyException(e.getMessage());
		}
		//NOME|EXPIREDATE
		if(plain == null || plain.indexOf("|") == -1){
			LOG.log(Level.WARNING,"Invalid key " + licenseKey);
			throw new  InvalidLicenseKeyException("Invalid key " + licenseKey);
		}

		String[] values = plain.split("\\|");
		LOG.log(Level.WARNING,"Testing Key for " + values[0]  + " " + values[1] + " with ts " + values[2]);

		if(!type.equals(values[0])){
			LOG.log(Level.WARNING,"Invalid key " + licenseKey);
			throw new  InvalidLicenseKeyException("Invalid key " + licenseKey);
		}

		if(!tag.equals(values[1])){
			LOG.log(Level.WARNING,"Invalid key " + licenseKey);
			throw new  InvalidLicenseKeyException("Invalid key " + licenseKey);
		}

		long max  = Long.parseLong(values[2]);
		if(max < System.currentTimeMillis()){
			String message = "Key " + licenseKey + " expired since " + new Date(max);
			LOG.log(Level.WARNING,message);
			throw new  InvalidLicenseKeyException(message);
		}

		LOG.log(Level.INFO,"Key valid until " + new Date(max));
	}
	
	public void registerLicense(final String licenseBundleId, final ProcessorRaw raw) throws InvalidDeviceDataException {

		LicenseActivationRaw activationRaw = new LicenseActivationRaw(){
			@Override
			public String getBundleId() {				
				return licenseBundleId;
			}
			@Override
			public String getId() {				
				return null;
			}
			public String getName() {
				return "";
			}
			@Override
			public Date getActivationDate() {

				return new Date();
			}
			@Override
			public String getBrand() {

				return raw.getBrand();
			}
			@Override
			public String getCarrier() {

				return raw.getCarrier();
			}
			@Override
			public String getEmail() {

				return raw.getEmail();
			}
			@Override
			public String getModel() {

				return raw.getDevice();
			}
			@Override
			public String getPin() {

				return raw.getPin();
			};

		};

		try {
			licenseService.doLicenseActivation(activationRaw);
		} catch (EntityNotFoundException e) {

			throw new InvalidDeviceDataException();

		}


	}
}
