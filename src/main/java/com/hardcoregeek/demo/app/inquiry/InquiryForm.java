package com.hardcoregeek.demo.app.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * This is completed in Easy mode. If you want to practice, please delete this file.
 * イージーモードではこちらは完成させてあります。作成を練習したい場合は一度ファイルごと削除してください。
 */
public class InquiryForm {
    public InquiryForm(String name, String email, String contents) {
        super();
        this.name = name;
        this.email = email;
        this.contents = contents;
    }


    @Size(min = 1, max = 20, message = "Please input 20 characters or less")
    private final String name;

    @NotNull
    @Email(message = "Invalid E-mail Format")
    private final String email;

    @NotNull
    private final String contents;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContents() {
        return contents;
    }


}
