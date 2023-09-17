package com.alone.special.product.store.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;
import com.alone.special.product.store.ProductStore;

@Repository
public class ProductStoreLogic implements ProductStore {
@Autowired
private SqlSession session;

@Override
public int insertProduct(SqlSession session, Product product) {
	int result = session.insert("ProductMapper.insertProduct",product );
	return result;
}

@Override
public int selectListCount(SqlSession session) {
	int result = session.selectOne("ProductMapper.selectListCount");
	return result;
}

@Override
public List<Product> selectProductList(SqlSession session, ProductPageInfo pInfo) {
	int limit = pInfo.getRecordCountPerPage();
	int offset = (pInfo.getCurrentPage()-1)*limit;
	RowBounds rowBounds = new RowBounds(offset,limit);
	List<Product> pList= session.selectList("ProductMapper.selectProductList",null, rowBounds);
	return pList;
}

@Override
public Product selectOne(SqlSession session, Integer sProductId) {
	Product productOne = session.selectOne("ProductMapper.selectProductById",sProductId);
	return productOne;
}

@Override
public String[]  productsel(SqlSession session, String[] productIdArray) {
	String[]  product = session.selectList("ProductMapper.getRecentProducts", productIdArray).toArray(new String[0]);
	return product;
}

@Override
public int updateproduct(SqlSession session, Product product) {
	int result = session.update("ProductMapper.updateProduct", product);
	return result;
}
}