import axios from '../custom-axios/axios-js';


const EshopService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    addBook: (name, author,categories, availableCopies) => {
        return axios.post(`/books/add`, {
            "name": name,
            "author": author,
            "categories": categories,
            "availableCopies": availableCopies,


        })
    },
    editBook: (id, name, author,categories, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "author": author,
            "categories": categories,
            "availableCopies": availableCopies,
        })
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }

}


export default EshopService;