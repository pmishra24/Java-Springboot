package com.prashant.lms;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library")
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id){
        return libraryService.getBookById(id);
    }

    @GetMapping("/member/{id}")
    public Member getMemberById(@PathVariable Long id){
        return libraryService.getMemberById(id);
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book){
        return libraryService.saveBook(book);
    }

    @PostMapping("/member")
    public Member saveMember(@RequestBody Member member){
        return libraryService.saveMember(member);
    }

    @PutMapping("/borrow")
    public Member borrow(@RequestBody BorrowRequest borrowRequest){
        return libraryService.borrowBook(libraryService.getMemberById(borrowRequest.getmemberId()), libraryService.getBookById(borrowRequest.getbookId()));
    }

}
