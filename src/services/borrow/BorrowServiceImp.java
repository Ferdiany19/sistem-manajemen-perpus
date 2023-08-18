package services.borrow;

import java.time.LocalDate;
import java.util.List;

import dao.BorrowDao;
import models.Borrow;

public class BorrowServiceImp implements BorrowService {
    BorrowDao borrowDao;

    public BorrowServiceImp(BorrowDao borrowDao) {
        this.borrowDao = borrowDao;
    }

    @Override
    public void createBorrow(Borrow borrow) {
        borrow.setTanggalPinjam(LocalDate.now());
        borrowDao.save(borrow);
    }

    @Override
    public List<Borrow> getAllBorrow() {
        return borrowDao.findAll();
    }

    @Override
    public Borrow getBorrowById(Integer id) {
        return borrowDao.findById(id);
    }

    @Override
    public void returnBook(Integer id, Borrow data) {
        data.setTanggalKembali(LocalDate.now());
        this.borrowDao.update(id, data);
        System.out.println("Pengembalian buku berhasil!");
    }

}
