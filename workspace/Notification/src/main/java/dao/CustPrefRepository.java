package dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import dto.CustPref;

@Repository("custPrefRepo")
public interface CustPrefRepository extends MongoRepository<CustPref, String>{
	public List<CustPref> findByCustomerId(String customerId);
}
