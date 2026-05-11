package com.prashant.lms;

import com.prashant.jobapi.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public LibraryService(BookRepository bookRepository, MemberRepository memberRepository){
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member borrowBook(Member member, Book book){
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies == null || availableCopies == 0)
            throw new BookNotAvailableException("There is no available of copy of book with title " + book.getTitle());

        book.setAvailableCopies(availableCopies - 1);
        member.updateBorrowedBooks(book);

        bookRepository.save(book);
        memberRepository.save(member);

        return member;
    }

    @Transactional
    public Book updateBookByTitleAndAuthor(Book book){
        Book existingBook =  this.bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor()).orElseThrow(() -> new NotFoundException("Book not found"));
        existingBook.setAvailableCopies(book.getAvailableCopies());
        existingBook.setIsbn(book.getIsbn());

        return this.bookRepository.save(existingBook);
    }


    @Transactional
    public Member updateMemberByNameAndEmail(Member member){
        Member existingMember =  this.memberRepository.findByNameAndEmail(member.getName(), member.getEmail()).orElseThrow(() -> new NotFoundException("Member not found"));
        existingMember.setBorrowedBooks(member.getBorrowedBooks());

        return this.memberRepository.save(existingMember);
    }

    @Transactional
    public Book saveBook(Book book){
        return this.bookRepository.save(book);
    }

    @Transactional
    public Member saveMember(Member member){
        return this.memberRepository.save(member);
    }

    @Transactional
    public Book getBookById(Long id){
        return this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Transactional
    public Member getMemberById(Long id){
        return this.memberRepository.findById(id).orElseThrow(() -> new NotFoundException("Member not found"));
    }
}
