package org.productivity.cdyne4j.cdyne.smsnotify;

import java.util.ArrayList;
import java.util.List;

import org.productivity.cdyne4j.CDYNEException;
import org.productivity.cdyne4j.cdyne.AbstractCDYNERq;
import org.productivity.cdyne4j.cdyne.AbstractCDYNERs;

/**
 * GetMessageStatusByReferenceIDRq implements the request side of: https://www.cdyne.com/sms/
 * 
 * <pre>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 * 
 * @author Justin Yunke <justin-github@yunke.us>
 */
public class GetMessageStatusByReferenceIDRq extends AbstractCDYNERq {
	private static final long serialVersionUID = 8809648986615910103L;
	
	protected String referenceID = null;
	
	public GetMessageStatusByReferenceIDRq() { }
	
	public GetMessageStatusByReferenceIDRq(String referenceID) {
		this.referenceID = referenceID;
	}
	
	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	@Override
	public byte getRequestType() {
		return RQ_TYPE_PARAMS;
	}

	@Override
	public byte getResponseType() {
		return RS_TYPE_XML;
	}

	@Override
	public Class<? extends AbstractCDYNERs> getResponseClass() {
		return GetMessageStatusRs.class;
	}

	@Override
	public List<NameValue> params() throws CDYNEException {
		List<NameValue> list = new ArrayList<>();
		
		list.add(new NameValue("ReferenceID",this.referenceID));
		list.add(new NameValue("LicenseKey",this.licenseKey));
		
		return list;
	}
	
	@Override
	public String getServiceName() {
		return "GetMessageStatusByReferenceID";
	}
}
