public class WithoutElememMatch{

/**
*Returns the parent book corresponding to the sagaName criteria with the unfiltered child collection books
*/
public Book findBookNumberInSaga(String sagaName, Integer bookNumber){

   Query query = Query.query(Criteria.where("series").is(sagaName).and("books.seriesNumber").is(bookNumber));

   MongoTemplate template = getMongoTemplate();
   
   return template.find(query);

}

 




public static void main(String[] args){

     Book saga = findBookNumberInSaga("A song of ice and Fire", 4);
     Book numberFor = null;
      
    Iterator<Book> books = saga.getBooks();

        while (books.hasNext()){
            Book  currentBook= books.next();

             if(book.getSeriesNumber() == 4){
                numberFor = currentBook;
             }           
        }
		
	}
 
}