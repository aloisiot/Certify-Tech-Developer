for word in $(cat lista_nomes.txt)
do
	if [ $word = "Marcelo" ]; then
		echo "Encontrei o $word"
	else
		let a=$a+1
	fi
done
echo "Encontrados  $a nomes diferentes de Marcelo"
