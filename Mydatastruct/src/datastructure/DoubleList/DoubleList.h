#ifndef _DOUBLE_H
#define _DOUBLE_H

#include <cstdlib>
#include <cstdint>

namespace mydatastructure
{

template<typename T>
class doubleList
{
private:
	struct Node
	{
		T data;
		Node * prev;
		Node * next;

		Node(const T & d = T(), Node * p = NULL, Node * n = NULL)
			:data(d), prev(p), next(n){}
	};

public:
	class const_iterator
	{
	public:

		// Public constructor for const_iterator.
		const_iterator() : current(NULL)
		{ }

		// Return the T stored at the current position.
		// For const_iterator, this is an accessor with a
		// const reference return type.
		const T & operator* () const
		{
			return retrieve();
		}

		const_iterator & operator++ ()
		{
			current = current->next;
			return *this;
		}

		const_iterator operator++ (int)
		{
			const_iterator old = *this;
			++(*this);
			return old;
		}

		const_iterator & operator-- ()
		{
			current = current->prev;
			return *this;
		}

		const_iterator operator-- (int)
		{
			const_iterator old = *this;
			--(*this);
			return old;
		}

		bool operator== (const const_iterator & rhs) const
		{
			return current == rhs.current;
		}

		bool operator!= (const const_iterator & rhs) const
		{
			return !(*this == rhs);
		}

	protected:
		Node *current;

		// Protected helper in const_iterator that returns the T
		// stored at the current position. Can be called by all
		// three versions of operator* without any type conversions.
		T & retrieve() const
		{
			return current->data;
		}

		// Protected constructor for const_iterator.
		// Expects a pointer that represents the current position.
		const_iterator(Node *p) : current(p)
		{ }

		friend class doubleList<T>;
	};

	class iterator : public const_iterator
	{
	public:

		// Public constructor for iterator.
		// Calls the base-class constructor.
		// Must be provided because the private constructor
		// is written; otherwise zero-parameter constructor
		// would be disabled.
		iterator()
		{ }

		T & operator* ()
		{
			return retrieve();
		}

		// Return the T stored at the current position.
		// For iterator, there is an accessor with a
		// const reference return type and a mutator with
		// a reference return type. The accessor is shown first.
		const T & operator* () const
		{
			return const_iterator::operator*();
		}

		iterator & operator++ ()
		{
			current = current->next;
			return *this;
		}

		iterator operator++ (int)
		{
			iterator old = *this;
			++(*this);
			return old;
		}

		iterator & operator-- ()
		{
			current = current->prev;
			return *this;
		}

		iterator operator-- (int)
		{
			iterator old = *this;
			--(*this);
			return old;
		}

	protected:
		// Protected constructor for iterator.
		// Expects the current position.
		iterator(Node *p) : const_iterator(p)
		{ }

		friend class doubleList<T>;
	};

public:
	doubleList()
	{
		init();
	}

	~doubleList()
	{
		clear();
		delete head;
		delete tail;
	}

	doubleList(const doubleList & rhs)
	{
		init();
		*this = rhs;
	}

	doubleList & operator=(const doubleList & rhs)
	{
		if (*this == &rhs)
			return *this;
		clear();
		for (const_iterator itr = rhs.begin(); rhs != rhs.end(); ++itr)
			push_back(*itr);
		return *this;
	}

	iterator begin()
	{
		return iterator(head->next);
	}

	iterator begin()const
	{
		return const_iterator(head->next);
	}

	iterator end()
	{
		return iterator(tail);
	}

	iterator end()const
	{
		return	const_iterator(tail);
	}

	int size() const
	{
		return theSize;
	}

	bool empty()const
	{
		return theSize == 0;
	}

	void clear()
	{
		while (!empty())
			pop_front();
	}

	T & front()
	{
		return *begin();
	}

	const T & front() const
	{
		return *begin();
	}

	T & back()
	{
		return *--end();
	}

	const T & back()const
	{
		return *--end();
	}

	void  push_front(const T & x)
	{
		insert(begin(), x);
	}

	void push_back(const T & x)
	{
		insert(end(), x);
	}

	void pop_front()
	{
		erase(begin());
	}

	void pop_back()
	{
		erase(--end());
	}

	iterator insert(iterator itr, const T & x)
	{
		Node * p = itr.current;
		++theSize;
		return iterator(p->prev = p->prev->next = new Node(x, p->prev, p));
	}

	iterator erase(iterator itr)
	{
		Node * p = itr.current;
		iterator retval(p->next);
		p->prev->next = p->next;
		p->next->prev = p->prev;
		delete p;
		--theSize;

		return retval;
	}

	iterator erase(iterator start, iterator end)
	{
		for (iterator itr = start; itr !+ end;)
			itr = erase(itr);
		return end;
	}

private:
	int theSize;
	Node * head;
	Node * tail;

	void init()
	{
		theSize = 0;
		head = new Node;
		tail = new Node; 
		head->next = tail;
		tail->prev = head;
	}
};

}
#endif