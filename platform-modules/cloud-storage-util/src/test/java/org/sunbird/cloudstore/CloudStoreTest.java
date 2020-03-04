package org.sunbird.cloudstore;

import com.typesafe.config.ConfigFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sunbird.common.Platform;
import java.util.HashMap;

public class CloudStoreTest {

	@BeforeClass
	public static void init(){
		Platform.config = ConfigFactory.parseMap(new HashMap<String, Object>(){{
			put("cloud_storage_type","azure");
			put("azure_storage_key","key123");
			put("azure_storage_secret","sec123");
			put("azure_storage_container", "sunbird-dev");
		}}).resolve();
	}

	@Test
	public void getContainerNameTest() {
		Assert.assertEquals("sunbird-dev",CloudStore.getContainerName());
	}

}