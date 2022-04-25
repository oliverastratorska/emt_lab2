import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';

import Categories from '../Categories/categories';

import Books from '../Books/BookList/books';
import EshopService from "../../repository/eshopRepository";
import Header from "../Header/header";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            author: [],
            categories: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"containter"}>

                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>
                        }/>
                        <Route path={"/books/add"} exact render={() => <BookAdd author={this.state.author}
                                                                                categories={this.state.categories}
                                                                                 onAddBook={this.addBook}/>
                        }/>
                        <Route path={"/books/edit/:id"} exact
                               render={() => <BookEdit author={this.state.author}
                                                          onEditBook={this.editBook}
                                                          books ={this.state.selectedBook}
                                                          categories={this.state.categories}
                               />}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books} onDelete={this.deleteBook}
                                      onEdit={this.getBook}/>
                        }/>
                        <Redirect to={"/books"}/>
                    </div>
                </main>

            </Router>

        )
    }

    componentDidMount() {
        this.loadAuthors();
        this.loadBooks();
        this.loadCategories();
    }

    loadAuthors = () => {
        EshopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    author: data.data
                })
            })
    }

    loadBooks = () => {
        EshopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }
    loadCategories = () => {
        EshopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }

    deleteBook = (id) => {
        EshopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, author,categories, availableCopies) => {
        EshopService.addBook(name, author,categories, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        EshopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }
    editBook = (id, name, author,categories, availableCopies) => {
        EshopService.editBook(id, name, author,categories, availableCopies)
            .then(() => {
                this.loadBooks()
            });
    }
}

export default App;
