package com.algaworks.brewer.validation.validator;


import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

import com.algaworks.brewer.validation.AtributoConfirmacao;

public class AtributoConfirmacaoValidator implements ConstraintValidator<AtributoConfirmacao, Object> {

	private String atributo;
	private String atributoConfirmacao;
	
	@Override
	public void initialize(AtributoConfirmacao constraintAnnotation) {
		this.atributo = constraintAnnotation.atributo();
		this.atributoConfirmacao = constraintAnnotation.atributoConfirmacao();
		
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		boolean valido = false;
		try {
			Object valorAtributo = BeanUtils.getArrayProperty(object, this.atributo);
			Object valorAtributoConfirmacao = BeanUtils.getArrayProperty(object, this.atributoConfirmacao);
		
			String auxValorAtributo = ((String) Arrays.asList((Object[])valorAtributo).get(0)).trim();
			String auxValorAtributoConfirmacao = ((String) Arrays.asList((Object[])valorAtributoConfirmacao).get(0)).trim();
			valido = ambosSaoBlancos(auxValorAtributo, auxValorAtributoConfirmacao) || ambosSaoIguais(auxValorAtributo, auxValorAtributoConfirmacao);
		}  catch (Exception e) {
			throw new RuntimeException("Erro recuperando valores dos atributos", e);
		}
		
		if (!valido) {
			context.disableDefaultConstraintViolation();
			String mensagem = context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
			violationBuilder.addPropertyNode(atributoConfirmacao).addConstraintViolation();
		}
		
		return valido;
	}

	private boolean ambosSaoIguais(Object valorAtributo, Object valorAtributoConfirmacao) {
		return (valorAtributo != null) && valorAtributo.equals(valorAtributoConfirmacao);
	}

	private boolean ambosSaoBlancos(Object valorAtributo, Object valorAtributoConfirmacao) {
		return ((valorAtributo == null || valorAtributo.equals("")) && (valorAtributoConfirmacao == null || valorAtributoConfirmacao.equals("")));
	}

}
