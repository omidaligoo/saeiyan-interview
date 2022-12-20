package com.example.saeiyanjavaintervew.q2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SynchronizedHashMap<K, V> extends HashMap<K, V> {

    private final Object lock = new Object();

    public SynchronizedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
    public SynchronizedHashMap(int initialCapacity) {
        super(initialCapacity);
    }
    public SynchronizedHashMap() {
        super();
    }
    public SynchronizedHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }
    

    private void sync(Runnable runnable) {
        synchronized (lock) {
            runnable.run();
        }
    }

    private <T> void sync(Consumer<T> consumer, T t) {
        synchronized (lock) {
            consumer.accept(t);
        }
    }

    private <T> T sync(Supplier<T> supplier) {
        synchronized (lock) {
            return supplier.get();
        }
    }

    private <T, R> R sync(Function<T, R> function, T t) {
        synchronized (lock) {
            return function.apply(t);
        }
    }

    private <T, U, R> R sync(BiFunction<T, U, R> function, T t, U u) {
        synchronized (lock) {
            return function.apply(t, u);
        }
    }

    @Override
    public int size() {
        return sync(super::size);
    }

    @Override
    public boolean isEmpty() {
        return sync(super::isEmpty);
    }

    @Override
    public V get(Object key) {
        return sync(super::get, key);
    }

    @Override
    public boolean containsKey(Object key) {
        return sync(super::containsKey, key);
    }

    @Override
    public V put(K key, V value) {
        return sync(super::put, key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        sync(super::putAll, m);
    }

    @Override
    public V remove(Object key) {
        synchronized (lock) {
            return super.remove(key);
        }
    }

    @Override
    public void clear() {
        sync(super::clear);
    }

    @Override
    public boolean containsValue(Object value) {
        return sync(super::containsValue, value);
    }

    @Override
    public Set<K> keySet() {
        return sync(super::keySet);
    }

    @Override
    public Collection<V> values() {
        return sync(super::values);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return sync(super::entrySet);
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return sync(super::getOrDefault, key, defaultValue);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return sync(super::putIfAbsent, key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return sync(super::remove, key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        synchronized (lock) {
            return super.replace(key, oldValue, newValue);
        }
    }

    @Override
    public V replace(K key, V value) {
        return sync(super::replace, key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return sync(super::computeIfAbsent, key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return sync(super::computeIfPresent, key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return sync(super::compute, key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        synchronized (lock) {
            return super.merge(key, value, remappingFunction);
        }
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        sync(super::forEach, action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        sync(super::replaceAll, function);
    }

    @Override
    public Object clone() {
        return sync(super::clone);
    }

    @Override
    public boolean equals(Object o) {
        return sync(super::equals, o);
    }

    @Override
    public int hashCode() {
        return sync(super::hashCode);
    }

    @Override
    public String toString() {
        return sync(super::toString);
    }


}
