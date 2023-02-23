package com.zallpy.listfilter.resources

import com.zallpy.listfilter.model.Categories

class DBResourceMock {
    companion object {
        fun getCategories() : MutableList<Categories> {
            var list = ArrayList<Categories>()

            list.add(
                Categories(
                    "Ação",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Aventura",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Comédia",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Comédia e ação",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Comédia romântica",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Documentário",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Drama",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Fantasia",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Ficção Científica",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Guerra",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Mistério",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Musical",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Policial",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Romance",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Suspense",
                    "Lorem Ipsum is simply dummy text...")
            )
            list.add(
                Categories(
                    "Terror",
                    "Lorem Ipsum is simply dummy text...")
            )
        return list
        }
    }
}