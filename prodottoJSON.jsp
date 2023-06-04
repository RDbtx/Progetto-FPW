<%-- 
    Document   : prodottoJSP
    Created on : 30 mag 2023, 16:45:18
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="name" value="${prodotto.getNome()}"/>
    <json:property name="desc" value="${prodotto.getDescrizione()}"/>
    <json:property name="software" value="${prodotto.getSoftware()}"/>
    <json:property name="price" value="${prodotto.getPrezzo()}"/>
    <json:property name="quantity" value="${prodotto.getQuantita()}"/>
    <json:property name="user" value="${prodotto.getUtente_id()}"/>
    <json:property name="foto" value="${prodotto.getFoto()}"/>
</json:object>
