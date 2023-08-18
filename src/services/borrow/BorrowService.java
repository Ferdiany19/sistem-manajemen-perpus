package services.borrow;

import java.util.List;

import models.Borrow;

public interface BorrowService {
    void createBorrow(Borrow borrow);

    List<Borrow> getAllBorrow();

    Borrow getBorrowById(Integer id);

    void returnBook(Integer id, Borrow data);
}
