package com.mulesoft.jaxrs.raml.jaxb;

import java.lang.annotation.Annotation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.mulesoft.jaxrs.raml.annotation.model.IAnnotationModel;
import com.mulesoft.jaxrs.raml.annotation.model.IBasicModel;

/**
 * <p>JAXBModelElement class.</p>
 *
 * @author kor
 * @version $Id: $Id
 */
public class JAXBModelElement {

	private static final String NAMESPACE = "namespace";
	private static final String NAME = "name";
	protected IBasicModel originalType;
	protected String namespace;
	protected String typeName;
	protected String elementName;
	final JAXBRegistry registry;

	/**
	 * <p>Constructor for JAXBModelElement.</p>
	 *
	 * @param model a {@link com.mulesoft.jaxrs.raml.annotation.model.IBasicModel} object.
	 * @param registry a {@link com.mulesoft.jaxrs.raml.jaxb.JAXBRegistry} object.
	 */
	public JAXBModelElement(IBasicModel model,JAXBRegistry registry) {
		super();
		this.registry=registry;
		if (model==null){
			throw new IllegalArgumentException();
		}
		this.originalType=model;
		elementName=value(XmlElement.class, NAME);
		namespace=value(XmlElement.class, NAMESPACE);
		typeName=value(XmlType.class,NAME);
	}

	/**
	 * <p>value.</p>
	 *
	 * @param cl a {@link java.lang.Class} object.
	 * @param name a {@link java.lang.String} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String value(Class<? extends Annotation>cl,String name){
		IAnnotationModel annotation = originalType.getAnnotation(cl.getSimpleName());
		if( annotation!=null){
			return annotation.getValue(name);
		}
		return null;
	}
	
}
