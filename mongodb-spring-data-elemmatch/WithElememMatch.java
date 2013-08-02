public class WithElememMatch{


/**
* Returns the parent book corresponding to the sagaName criteria with a size 1 collection 'children' collection whose seriesNumber
* property corresponds to the value of the seriesNumber argument
*/
public Book findBookNumberInSaga(String sagaName, Integer bookNumber){

        // the query object
        Criteria findSeriesCriteria = Criteria.where("title").is(title);
        // the field object
        Criteria findSagaNumberCriteria = Criteria.where("books").elemMatch(Criteria.where("seriesNumber").is(seriesNumber));
        BasicQuery query = new BasicQuery(findSeriesCriteria.getCriteriaObject(), findSagaNumberCriteria.getCriteriaObject());

        return  mongoOperations.find(query, Book.class);

}






public static void main(String[] args){

    // get the parent book
     Book parentBook = findBookNumberInSaga("A song of ice and Fire", 4);
      Book numberFor;
	  
	  // null checks
     if(book != null && CollectionUtils.isNotEmpty(book.getBooks()){
	 // get the only book we are interested in
	   numberFor = parentBook.getBooks().get(0);
	 
	 }
     

 
}