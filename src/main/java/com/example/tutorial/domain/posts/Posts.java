package com.example.tutorial.domain.posts;

import com.example.tutorial.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 접근 권한이 protected이고 argument가 없는 생성자
// protected로 설정하는 이유? : Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // 클래스 내 모든 필드의 getter 메소드 자동 생성
@Entity // DB table에 매핑되는 클래스
public class Posts extends BaseTimeEntity {

    @Id // pk 필드임을 명시
    @GeneratedValue // pk의 생성 규칙, default: auto increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // String의 경우 varchar(255)가 default. "TEXT"로 타입 변경함
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더패턴 클래스 생성, 선언 시 생성자에 포함된 필드만 빌더에 포함됨
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}