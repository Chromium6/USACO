from django.http import HttpResponse, Http404
from django.shortcuts import *
from django.urls import reverse
from django.views import generic

from .models import Question, Choice

# Generic views

class IndexView(generic.ListView):
    template_name = "polls/index.html"
    context_object_name = "latest_question_list"

    def get_queryset(self):
        # Get recent five questions
        return Question.objects.order_by('-pub_date')[:5]

class DetailView(generic.DetailView):
    model = Question
    template_name = "polls/detail.html"
    
class ResultsView(generic.DetailView):
    model = Question
    template_name = "polls/results.html"

# define what happens when you go to [WEBSITE]/index
def index(request):
    # get the latest 5 questions
    latest_question_list = Question.objects.order_by('-pub_date')[:5]
    context = {
        "latest_question_list": latest_question_list
    }
    return render(request, 'polls/index.html', context)

# define a view for specific arguments
def detail(request, q_id):
    question = get_object_or_404(Question, pk=q_id)
    return render(request, 'polls/detail.html', {'question':question})

def results(request, q_id):
    question = get_object_or_404(Question, pk=q_id)
    return render(request, 'polls/results.html', {'question': question})

def vote(request, q_id):
    # shortcut for getting this Question from all Questions
    question = get_object_or_404(Question, pk=q_id)
    try:
        # request.POST[] is a dictionary for accessing submitted data by name (always Strings)
        # Can also be accessed by request.GET()
        selected_choice = question.choice_set.get(pk=request.POST['choice'])
    # KeyError thrown by request,POST if no info availabe for selection
    except (KeyError, Choice.DoesNotExist):
        # redirect back to voting form with an error message
        return render(request, 'polls/detail.html', {
            'question': question,
            'error_message': "You didn't select a choice.",
        })
    else:
        selected_choice.votes += 1
        selected_choice.save()
        # Always return an HttpResponseRedirect after successfully dealing
        # with POST data. This prevents data from being posted twice if a
        # user hits the Back button.
        return HttpResponseRedirect(reverse('polls:results', args=(question.id,)))