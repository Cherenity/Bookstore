package harjoitus.bookstore.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryId;

  private String name;

  @OneToMany (cascade = CascadeType.ALL, mappedBy = "category")
  private List<Book> books;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public void setCategoryId(Long id) {
    this.categoryId = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Category [id=" + categoryId + ", name=" + name + "]";
  }

}
